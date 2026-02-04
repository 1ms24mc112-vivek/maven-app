pipeline {
    agent any

    environment {
        IMAGE_NAME = "viveknshet112/maven-app"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/1ms24mc112-vivek/maven-app.git', branch: 'main'
            }
        }

        stage('Build Maven Project') {
            steps {
                dir("app") {
            sh "mvn clean package -DskipTests"
            }
        }
    }


        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub112') {
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline Successful "
        }
        failure {
            echo "Pipeline Failed "
        }
        always {
            deleteDir()
        }
    }
}
