pipeline {
    agent {
        docker {
            label 'docker'
            image 'gradle:4.10.1-jdk8-alpine'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle --no-daemon clean build'
            }
        }
    }
}
