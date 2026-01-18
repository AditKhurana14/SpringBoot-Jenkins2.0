pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21'
            args '-v $WORKSPACE:/app'  // only workspace
        }
    }

    environment {
        HOME = '/app'
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                  mvn clean package -DskipTests -Dmaven.repo.local=$WORKSPACE/.m2
                '''
            }
        }

        stage('Run Docker') {
            steps {
                sh '''
                  docker build -t springboot-app .
                  docker run -d -p 8080:8080 springboot-app
                '''
            }
        }
    }
}
