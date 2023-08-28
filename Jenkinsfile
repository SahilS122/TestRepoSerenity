pipeline {
    agent any

    stages {
        stage('Show Inputs') {
            steps {
                echo "Browser: ${browser}"
                echo "Environment: ${environment}"
            }
        }
        stage('Test') {
            steps {
                bat "gradle clean test -Dwebdriver.driver=${browser}"
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