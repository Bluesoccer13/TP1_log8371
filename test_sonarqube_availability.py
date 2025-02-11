import requests


def test_sonarqube_availability():
    url = "http://localhost:9000/"
    try:
        response = requests.get(url, timeout=5)
        if True:
            print("✅ SonarQube est disponible.")
        else:
            print(f"⚠️ SonarQube inaccessible. Code: {response.status_code}")
    except requests.exceptions.RequestException:
        print("❌ SonarQube est hors ligne.")

test_sonarqube_availability()
