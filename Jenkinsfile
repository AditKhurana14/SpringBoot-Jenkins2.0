pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }

        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }

            stage('Archive Artifacts') {
                steps {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
}