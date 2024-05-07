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
                try {
                    bat 'mvn test'
                }catch(Exception e){
                    currentBuild.result = 'FAILED'
                    error "Test Failed" : ${e.message}"
                }
                
            }
        }
        stage('Clean Up') {
            steps {
                bat 'rmdir /s /q target'
            }
        }
    }
}
