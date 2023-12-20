pipeline {

	agent any
	
	triggers {
		pollSCM('* * * * *')
	}
	
	stages {
	
		stage('Verify stage') {
			steps {
				echo '--------------:: This is a verify stage :: ------------'
				sh 'mvn clean verify'
			}
	
		}
		
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
	
		}
		
	}

}