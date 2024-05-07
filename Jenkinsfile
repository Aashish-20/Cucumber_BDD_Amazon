pipeline {
    agent any
    stages {
        stage('Start') {
            steps {
                echo 'Starting Pipeline'
            }
        }
        stage('Build'){
            steps{
                bat 'mvn clean install'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Clean Up') {
            steps {
                bat 'rmdir /s /q target'
            }
        }
    }
}
