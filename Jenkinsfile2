pipeline {

	agent any
	
	triggers {
		pollSCM('* * * * *')
	}
	
	stages {
		
		stage('Compile stage') {
			steps {
				echo '--------------:: This is a compile stage :: ------------'
				bat 'mvn clean compile'
			}
	
		}
		
		stage('Test stage') {
			steps {
				echo '--------------:: This is a compile stage :: ------------'
				bat 'mvn clean test'
			}
			post {               
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/html/', 
                       reportFiles: 'index.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
	
		}
		
	}

}