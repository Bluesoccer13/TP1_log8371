/*
 * SonarQube
 * Copyright (C) 2009-2023 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
import {
  ContentLink,
  CoverageIndicator,
  DuplicationsIndicator,
  LightLabel,
  TextError,
} from 'design-system';
import * as React from 'react';
import { FormattedMessage, useIntl } from 'react-intl';
import { To } from 'react-router-dom';
import { duplicationRatingConverter, getLeakValue } from '../../../components/measure/utils';
import { translate, translateWithParameters } from '../../../helpers/l10n';
import { findMeasure, formatMeasure, localizeMetric } from '../../../helpers/measures';
import { getComponentDrilldownUrl } from '../../../helpers/urls';
import { BranchLike } from '../../../types/branch-like';
import { MetricKey, MetricType } from '../../../types/metrics';
import { QualityGateStatusConditionEnhanced } from '../../../types/quality-gates';
import { MeasureEnhanced } from '../../../types/types';
import { MeasurementType, Status, getMeasurementMetricKey } from '../utils';
import MeasuresCard from './MeasuresCard';

interface Props {
  componentKey: string;
  branchLike?: BranchLike;
  measurementType: MeasurementType;
  label: string;
  url: To;
  measures: MeasureEnhanced[];
  conditions: QualityGateStatusConditionEnhanced[];
  conditionMetric: MetricKey;
  newLinesMetric: MetricKey;
  afterMergeMetric: MetricKey;
}

export default function MeasuresCardPercent(
  props: React.PropsWithChildren<Props & React.HTMLAttributes<HTMLDivElement>>,
) {
  const {
    componentKey,
    branchLike,
    measurementType,
    label,
    url,
    measures,
    conditions,
    conditionMetric,
    newLinesMetric,
    afterMergeMetric,
  } = props;

  const intl = useIntl();

  const metricKey = getMeasurementMetricKey(measurementType, true);

  const value = getLeakValue(findMeasure(measures, metricKey));

  const newLinesValue = getLeakValue(findMeasure(measures, newLinesMetric));
  const newLinesLabel =
    measurementType === MeasurementType.Coverage
      ? 'overview.quality_gate.on_x_new_lines_to_cover'
      : 'overview.quality_gate.on_x_new_lines';
  const newLinesUrl = getComponentDrilldownUrl({
    componentKey,
    metric: newLinesMetric,
    branchLike,
    listView: true,
  });

  const afterMergeValue = findMeasure(measures, afterMergeMetric)?.value;

  const condition = conditions.find((c) => c.metric === conditionMetric);
  const conditionFailed = condition?.level === Status.ERROR;

  const requireLabel =
    condition &&
    intl.formatMessage(
      { id: 'overview.quality_gate.required_x' },
      {
        operator: condition.op === 'GT' ? '≤' : '≥',
        value: formatMeasure(condition.error, MetricType.Percent, {
          decimals: 2,
          omitExtraDecimalZeros: true,
        }),
      },
    );

  return (
    <MeasuresCard
      value={formatMeasure(value, MetricType.Percent)}
      metric={metricKey}
      url={url}
      label={label}
      failed={conditionFailed}
      icon={renderIcon(measurementType, value)}
    >
      <>
        <span className="sw-body-xs sw-mt-3">
          {requireLabel &&
            (conditionFailed ? (
              <TextError className="sw-font-regular" text={requireLabel} />
            ) : (
              <LightLabel>{requireLabel}</LightLabel>
            ))}
        </span>

        <div className="sw-flex sw-justify-between sw-items-center sw-mt-1">
          <LightLabel className="sw-flex sw-items-center sw-gap-1 ">
            <FormattedMessage
              defaultMessage={translate(newLinesLabel)}
              id={newLinesLabel}
              values={{
                link: (
                  <ContentLink
                    aria-label={translateWithParameters(
                      'overview.see_more_details_on_x_y',
                      newLinesValue ?? '0',
                      localizeMetric(newLinesMetric),
                    )}
                    className="sw-body-md-highlight sw-text-lg"
                    to={newLinesUrl}
                  >
                    {formatMeasure(newLinesValue ?? '0', MetricType.ShortInteger)}
                  </ContentLink>
                ),
              }}
            />
          </LightLabel>
          <LightLabel className="sw-mt-[1px]">
            {afterMergeValue && (
              <FormattedMessage
                defaultMessage={translate('overview.quality_gate.x_estimated_after_merge')}
                id="overview.quality_gate.x_estimated_after_merge"
                values={{
                  value: <strong>{formatMeasure(afterMergeValue, MetricType.Percent)}</strong>,
                }}
              />
            )}
          </LightLabel>
        </div>
      </>
    </MeasuresCard>
  );
}

function renderIcon(type: MeasurementType, value?: string) {
  if (type === MeasurementType.Coverage) {
    return <CoverageIndicator value={value} size="md" />;
  }

  const rating = duplicationRatingConverter(Number(value));
  return <DuplicationsIndicator rating={rating} size="md" />;
}
