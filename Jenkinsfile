pipeline {
    agent any
    stages {        
        stage("Compile") {
            steps {
                sh "./mvnw clean compile"
            }
        }
        stage("Unit test") {
            steps {
                sh "./mvnw test"
            }
        }
        stage("Code coverage") {
            steps {              
				jacoco(execPattern: 'target/jacoco.exec')
				publishHTML (target: [
				        reportDir: 'target/site/jacoco',
				        reportFiles: 'index.html',
				        reportName: "JaCoCo Report"
				    ]
				)
            }
        }
        stage("Install for All Environments") {
            steps {              
				sh "./mvnw install -DskipTests"
            }
        }
    }
    post {
		always {
			mail to: 'm.franco@proximanetwork.it',
			subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
			body: "Your build completed, please check: ${env.BUILD_URL}"
		}
	}
}