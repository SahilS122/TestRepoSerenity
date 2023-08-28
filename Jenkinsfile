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
            System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src * 'unsafe-inline' 'unsafe-eval'; script-src * 'unsafe-inline' 'unsafe-eval'; connect-src * 'unsafe-inline'; img-src * data: blob: 'unsafe-inline'; frame-src *; style-src * 'unsafe-inline';")
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