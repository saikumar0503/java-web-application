pipeline {
    agent any
    
    environment {
        PATH = "/opt/maven3/bin:$PATH"
    }
    stages {
        stage("Git Checkout") {
            steps {
                git credentialsId: 'cc988b5f-9f92-4537-97f6-86679fc2d1ca', url: 'https://github.com/saikumar0503/sai.git'
            }
        }
        stage("Maven Build") {
            steps {
                sh "mvn clean package"
                sh "mv target/*.war target/myweb.war"
            }
        }
        stage("deploy-dev") {
            steps {
                sshagent(['4483c13e-8e2b-4d4e-9eae-6057f987c9be']) {
                    sh '''
                    scp -o StrictHostKeyChecking=no target/myweb.war ubuntu@172.16.1.12:/tmp/myweb.war
                    ssh -o StrictHostKeyChecking=no ubuntu@172.16.1.12 "sudo mv /tmp/myweb.war /root/tomcat/webapps/"
                    '''
                }
            }
        }
    }
}
