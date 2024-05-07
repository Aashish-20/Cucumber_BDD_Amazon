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
                script{
              
                       if(currentBuild.result == 'FAILURE'){
                        error "Test Failed"
                     }

                }
            }
        }
        stage('Check Test Results') {
            steps {
                script {
                    // Check if any tests failed
                    def testResults = junit testResults: '*/target/surefire-reports/TEST-.xml'
                    if (testResults.failed > 0) {
                        error "Test(s) failed, stopping pipeline."
                    }
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
