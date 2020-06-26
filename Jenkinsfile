pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
	    	git 'https://github.com/BenjaminBoutrois/demoAssertionJunit.git'
		withMaven(maven: 'Maven 3.6.3') {
                	sh 'mvn package' 
		}
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
