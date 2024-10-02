pipeline {
    agent any
    tools {
        maven 'm398'
        jdk 'jdk8'
    }


    stages{
        stage('Preparattion') {
            steps {
                sh 'echo hello world'
            }
        }
        //stage('CheckOut SCM') {
        //    steps {
        //        git 'https://github.com/akhanal77/devopsproject.git'
         //   }
       // }
        stage('Compile & Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                sh "docker image build . -t pragra/api"
            }
        }
        stage('Publish Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                  sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
                  sh "docker image push pragra/api"
                }
            }
        }

    }


}
