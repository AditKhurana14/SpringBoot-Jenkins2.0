pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21'
            args '-v /var/jenkins_home/.m2:/var/jenkins_home/.m2'
            reuseNode true
        }
    }

    environment {
        HOME = '/var/jenkins_home'
        MAVEN_CONFIG = '/var/jenkins_home/.m2'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
