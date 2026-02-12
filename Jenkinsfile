pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /root/.m2:/root/.m2'
                }
            }
                
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
            
        stage('Archive Artifacts') {
            steps{
                archiveArtifacts artifacts:'target/*.jar, fingerprint:true

        }
    }
}
