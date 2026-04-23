pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven-3.8.6'
        JAVA_HOME = tool 'JDK-17'
        SELENIUM_HUB_URL = 'http://selenium-hub:4444/wd/hub'
        TEST_RESULTS_DIR = 'test-results'
        EMAIL_RECIPIENTS = 'team@company.com'
    }
    
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 60, unit: 'MINUTES')
        timestamps()
    }
    
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/votre-organisation/UyTester2026Clone.git', 
                    branch: '${env.BRANCH_NAME}'
            }
        }
        
        stage('Setup Environment') {
            steps {
                script {
                    echo "Setting up test environment..."
                    sh 'mkdir -p ${TEST_RESULTS_DIR}'
                }
            }
        }
        
        stage('Start Selenium Grid') {
            steps {
                script {
                    echo "Starting Selenium Grid..."
                    sh '''
                        docker-compose -f docker-compose.selenium.yml up -d
                        sleep 10
                    '''
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                script {
                    try {
                        echo "Running Selenium tests..."
                        sh '''
                            ${MAVEN_HOME}/bin/mvn clean test \
                                -Dwebdriver.remote.url=${SELENIUM_HUB_URL} \
                                -Dwebdriver.browser=chrome \
                                -Dtest.suite=testng.xml \
                                -Dsurefire.reports.dir=${TEST_RESULTS_DIR}/surefire-reports
                        '''
                    } catch (Exception e) {
                        currentBuild.result = 'UNSTABLE'
                        echo "Tests completed with some failures: ${e.getMessage()}"
                    }
                }
            }
        }
        
        stage('Generate Reports') {
            steps {
                script {
                    echo "Generating test reports..."
                    sh '''
                        # Copier les rapports TestNG
                        find . -name "*.html" -path "*/test-output/*" -exec cp {} ${TEST_RESULTS_DIR}/ \\;
                        find . -name "*.xml" -path "*/test-output/*" -exec cp {} ${TEST_RESULTS_DIR}/ \\;
                        
                        # Générer un rapport consolidé
                        ${MAVEN_HOME}/bin/mvn surefire-report:report \
                            -DoutputDirectory=${TEST_RESULTS_DIR}
                    '''
                }
            }
            post {
                always {
                    publishTestResults testResultsPattern: '${TEST_RESULTS_DIR}/**/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: '${TEST_RESULTS_DIR}',
                        reportFiles: 'index.html',
                        reportName: 'TestNG Report'
                    ])
                }
            }
        }
        
        stage('Performance Analysis') {
            when {
                anyOf {
                    branch 'main'
                    changeRequest()
                }
            }
            steps {
                script {
                    echo "Analyzing test performance..."
                    sh '''
                        # Analyser la durée des tests
                        python3 scripts/analyze_test_performance.py ${TEST_RESULTS_DIR}
                    '''
                }
            }
        }
    }
    
    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
            sh '''
                docker-compose -f docker-compose.selenium.yml down -v
            '''
        }
        
        success {
            script {
                echo '✅ All tests passed successfully!'
                
                // Envoyer notification Slack
                slackSend(
                    channel: '#testing',
                    color: 'good',
                    message: "✅ Tests Selenium réussis pour ${env.JOB_NAME} #${env.BUILD_NUMBER}\\nBranch: ${env.BRANCH_NAME}\\nCommit: ${env.GIT_COMMIT}"
                )
                
                // Envoyer email de succès
                emailext(
                    subject: "✅ Tests Selenium réussis - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                        <h2>🎉 Tests Selenium réussis!</h2>
                        <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                        <p><strong>Build:</strong> #${env.BUILD_NUMBER}</p>
                        <p><strong>Branch:</strong> ${env.BRANCH_NAME}</p>
                        <p><strong>Commit:</strong> ${env.GIT_COMMIT}</p>
                        <p><strong>Durée:</strong> ${currentBuild.durationString}</p>
                        <p><strong>Rapports:</strong> <a href="${env.BUILD_URL}TestNG_Report/">Consulter les rapports</a></p>
                    """,
                    to: "${EMAIL_RECIPIENTS}",
                    attachLog: true
                )
            }
        }
        
        failure {
            script {
                echo '❌ Tests failed!'
                
                // Envoyer notification Slack d'échec
                slackSend(
                    channel: '#testing',
                    color: 'danger',
                    message: "🚨 Tests Selenium échoués pour ${env.JOB_NAME} #${env.BUILD_NUMBER}\\nBranch: ${env.BRANCH_NAME}\\nCommit: ${env.GIT_COMMIT}\\nVérifier les logs: ${env.BUILD_URL}"
                )
                
                // Envoyer email d'échec
                emailext(
                    subject: "🚨 Tests Selenium échoués - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                        <h2>❌ Tests Selenium échoués!</h2>
                        <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                        <p><strong>Build:</strong> #${env.BUILD_NUMBER}</p>
                        <p><strong>Branch:</strong> ${env.BRANCH_NAME}</p>
                        <p><strong>Commit:</strong> ${env.GIT_COMMIT}</p>
                        <p><strong>Durée:</strong> ${currentBuild.durationString}</p>
                        <p><strong>Logs:</strong> <a href="${env.BUILD_URL}console">Consulter les logs</a></p>
                        <p><strong>Rapports:</strong> <a href="${env.BUILD_URL}TestNG_Report/">Consulter les rapports</a></p>
                    """,
                    to: "${EMAIL_RECIPIENTS}",
                    attachLog: true
                )
            }
        }
        
        unstable {
            script {
                echo '⚠️ Tests completed with some failures'
                
                slackSend(
                    channel: '#testing',
                    color: 'warning',
                    message: "⚠️ Tests Selenium instables pour ${env.JOB_NAME} #${env.BUILD_NUMBER}\\nBranch: ${env.BRANCH_NAME}\\nCertains tests ont échoué"
                )
            }
        }
    }
}
