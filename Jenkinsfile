pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat "gradle clean test"
            }
			stage('Show Inputs') {
            steps {
                echo "Browser:" ${browser}
				echo "Environment:" ${environment}
            }

            post {
                // If Gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                      allowMissing: false,
                      alwaysLinkToLastBuild: false,
                      keepAll: false,
                      reportDir: 'target/site/serenity/',
                      reportFiles: 'index.html',
                      reportName: 'Serenity Report',
                      reportTitles: '',
                      useWrapperFileDirectly: true])
                }
            }
        }
    }
}