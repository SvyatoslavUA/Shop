// Jenkinsfile

pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'app'
        CONTAINER_NAME = 'app'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

stage('Code Analysis') {
    steps {
        script {
            withSonarQubeEnv('SonarQube Server') {
                sh "mvn sonar:sonar \
                    -Dsonar.projectKey=my_project_key \
                    -Dsonar.organization=my_organization \
                    -Dsonar.host.url=http://sonarqube-server:9000 \
                    -Dsonar.login=my_sonar_token"
            }
        }
    }
}

        stage('Deploy to Docker') {
            steps {
                script {
                    sh "docker build -t $DOCKER_IMAGE ."
                    sh "docker run --name $CONTAINER_NAME -d -p 8080:8080 $DOCKER_IMAGE"
                }
            }
        }

        stage('Completion') {
            steps {
                script {
                    echo 'Deployment completed successfully'
                }
            }
        }
    }
}