pipeline {
    agent {
        label 'docker-java21'
    }

    options {
        skipDefaultCheckout(true)
    }

    environment {
        IMAGE = 'kamilzhanova-elmira-student-api:v1.1-kamilzhanova-elmira'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Kamilzhanova Elmira'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --no-daemon clean assemble'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew --no-daemon test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t "$IMAGE" .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect "$IMAGE"'
                echo 'Docker image exists'
            }
        }
    }
}
