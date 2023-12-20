pipeline {

	agent any
	
	triggers {
		pollSCM('* * * * *')
	}
	
	stages {

		
		stage('Compile stage') {
			steps {
				echo '--------------:: This is a compile stage :: ------------'
				sh 'mvn clean compile'
			}
	
		}
		
		stage('Test stage') {
			steps {
				echo '--------------:: This is a compile stage :: ------------'
				sh 'mvn clean test'
			}
			post {               
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'test-output/html/index.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
	
		}
		
	}

}