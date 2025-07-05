pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9.6'
        jdk 'JDK-8'
    }
    
    environment {
        BROWSER = 'chrome'
        HEADLESS = 'false'
        TEST_URL = 'https://useinsider.com'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
            post {
                always {
                    echo 'Test execution completed'
                }
            }
        }
        
        stage('Publish Reports') {
            steps {
                echo 'Publishing test reports...'
                publishTestNGResults(
                    pattern: '**/testng-results.xml',
                    failureOnFailedTestConfig: false,
                    showFailedBuildsInReportsGraph: true
                )
                
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'Selenium Test Reports',
                    reportTitles: 'Test Execution Reports'
                ])
            }
        }
    }
    
    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
        unstable {
            echo 'Build unstable!'
        }
    }
} 