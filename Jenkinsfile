pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat """
                docker run --rm ^
                  -v "%CD%:/app" ^
                  -w /app ^
                  maven:3.9.6-eclipse-temurin-21 ^
                  mvn clean install
                """
            }
        }

        stage('Test') {
            steps {
                bat """
                docker run --rm ^
                  -v "%CD%:/app" ^
                  -w /app ^
                  maven:3.9.6-eclipse-temurin-21 ^
                  mvn test
                """
            }
        }
    }
}
