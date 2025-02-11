import re
import subprocess

import requests


def get_sonarqube_port():
    try:
        # Run 'netstat' or 'ss' command to find Java-related ports
        result = subprocess.run(
            "ss -tlnp | grep java",
            shell=True,
            capture_output=True,
            text=True
        )

        # Extract the port number (find pattern like "127.0.0.1:PORT")
        match = re.search(r'127\.0\.0\.1:(\d+)', result.stdout)
        if match:
            print(f"✅ Port détecté :  {match.group(1)}.")
            return match.group(1)  # Extracted port
        else:
            print("❌ Impossible de détecter le port de SonarQube.")
            return None
    except Exception as e:
        print(f"⚠️ Erreur lors de la détection du port: {e}")
        return None

def test_sonarqube_availability():
    port = get_sonarqube_port()
    if not port:
        print("❌ SonarQube est hors ligne (aucun port trouvé).")
        return

    url = f"http://localhost:{port}/"
    try:
        response = requests.get(url, timeout=5)
        if response.status_code == 200:
            print(f"✅ SonarQube est disponible sur le port {port}.")
        else:
            print(f"⚠️ SonarQube inaccessible sur le port {port}. Code: {response.status_code}")
    except requests.exceptions.RequestException:
        print(f"❌ SonarQube est hors ligne sur le port {port}.")

test_sonarqube_availability()
