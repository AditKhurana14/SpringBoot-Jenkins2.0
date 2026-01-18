pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                docker run --rm \
                  -v "$PWD:/app" \
                  -v "$HOME/.m2:/root/.m2" \
                  -w /app \
                  maven:3.9.6-eclipse-temurin-21 \
                  mvn clean install
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                docker run --rm \
                  -v "$PWD:/app" \
                  -v "$HOME/.m2:/root/.m2" \
                  -w /app \
                  maven:3.9.6-eclipse-temurin-21 \
                  mvn test
                '''
            }
        }
    }
}
