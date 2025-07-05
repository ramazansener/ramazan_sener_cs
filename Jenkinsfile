pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'   
        jdk 'JDK-8'
    }

    stages {
        stage('Build & Test') {
            steps {
                echo 'Running Maven Tests...'
                sh 'mvn clean test'
            }
        }

        stage('Test Reports') {
            steps {
                echo 'Check test reports under target/surefire-reports/'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
