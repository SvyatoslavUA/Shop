pipeline {
    agent any

    tools {
        jdk 'jdk18'
        maven 'maven'
    }

    stages {

        stage('Build') {
            steps {
                echo 'Building the project'
                sh "mvn clean package"
            }
        }

        stage('Sonar Analysis') {
            steps {
                echo 'Running SonarQube analysis'
                script {
                    sh '''
                    mvn sonar:sonar -Dsonar.host.url=http://192.168.0.104:9000/ -Dsonar.login=squ_807777456bcc194614fdc12351f57d8546fec31f -Dsonar.projectName=ShopApp \
                    -Dsonar.java.binares=. \
                    -Dsonar.projectKey=Shop
                    '''
                    }
                }
        }
    }
}