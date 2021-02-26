pipeline {
    agent none
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
             agent {
                    docker {
                        image 'maven:3.6.3-jdk-8'
                    }
            }
            environment {CLASS_NAME='DEVOPS'}
            steps {
                sh 'java -version'
                sh 'echo $HOSTNAME'
                sh 'echo $CLASS_NAME'
            }
        }

        stage('Parallel Build') {
            failFast true
            parallel {
                stage('Buiild Java 8'){
                    agent {
                        docker {
                            image 'maven:3.6.3-jdk-8'
                        }
                    }
                    steps {
                        sh 'mvn install -DskipTests'
                        sh 'mv target/*.jar app-java8.jar'
                        archiveArtifacts artifacts: 'app-java8.jar', followSymlinks: false
                    }
                    
                }

                stage('Buiild Java 11'){
                    agent {
                        docker {
                            image 'maven:3.6.3-jdk-11'
                        }
                    }
                    steps {
                        sh 'mvn install -DskipTests'
                        sh 'mv target/*.jar app-java11.jar'
                        archiveArtifacts artifacts: 'app-java11.jar', followSymlinks: false

                    }
                    
                }
            }
           
        }
    }
    post {
            always {
                echo 'Hello World'
            }
            unsuccessful {
                echo 'Failed for some reason'
            }
        }
}