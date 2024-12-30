pipeline{
    agent any
    
    environment{
        PATH = "/opt/maven3/bin:$PATH"
    }
    stages{
        stage("Git Checkout"){
            steps{
                git credentialsId: 'cc988b5f-9f92-4537-97f6-86679fc2d1ca', url: 'https://github.com/saikumar0503/sai.git'

            }
        }
        stage("Maven Build"){
            steps{
                sh "mvn clean package"
                sh "mv target/*.war target/myweb.war"
            }
        }
        stage("deploy-dev"){
            steps{
                sshagent(['4483c13e-8e2b-4d4e-9eae-6057f987c9be']) {
                sh """
                    scp -o StrictHostKeyChecking=no target/myweb.war  ubuntu@ec2-13-232-181-168:/root/tomcat/webapps/
                    
                    ssh ubuntu@ec2-13-232-181-168:/root/tomcat/bin/shutdown.sh
                    
                    ssh ubuntu@ec2-13-232-181-168:/root/tomcat/bin/startup.sh
                
                """
            }
            
            }
        }
    }
}
