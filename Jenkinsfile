pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
        }
    }
    triggers{
        pollSCM('* * * *  *')
    }
    parameters { 
        string(
            name: 'DEPLOY_ENV', 
            defaultValue: 'staging', 
            description: 'This will be param') 
    }
    stages {
        stage('Prep') {
            environment {CLASS_NAME='DEVOPS'}
            steps {
                sh 'java -version'
                sh 'echo $HOSTNAME'
                sh 'echo $CLASS_NAME'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
    }
}