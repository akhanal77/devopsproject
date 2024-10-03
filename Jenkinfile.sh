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
                sh '''
                    echo "PATH = ${PATH}"
                    echo "MAVEN_HOME = ${MAVEN_HOME}"
                '''
            }
        }
        //stage('CheckOut SCM') {
        //    steps {
        //        git 'https://github.com/akhanal77/devopsproject.git'
         //   }
       // }
        stage('Compile & Package') {
            steps {
                withEnv(['JENKINS_MAVEN_AGENT_DISABLED=true']) {
                sh "mvn package"
             }
                withMaven(maven : 'm398') {
                //sh '$MVN_CMD clean deploy'
                //sh 'mvn -Dmaven.test.failure.ignore=true install'
                //sh 'mvn package -DskipTests'
                }
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
