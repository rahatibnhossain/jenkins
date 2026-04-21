pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh "./mvnw clean package"
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    docker.withRegistry('http://host.docker.internal:5001') {
                        def appImage = docker.build("localhost:5001/my-backend-app:${env.BUILD_NUMBER}")
                        appImage.push()
                        appImage.push("latest")
                    }
                }
            }
        }
    }
}