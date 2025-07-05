# Jenkins Integration Guide for Selenium Java Project

## 🔧 Required Jenkins Plugins

Make sure these plugins are installed in Jenkins:

1. **Git plugin** - For Git repository integration
2. **Maven Integration plugin** - For Maven build support
3. **TestNG Results plugin** - For TestNG test reports
4. **HTML Publisher plugin** - For HTML test reports
5. **Email Extension plugin** - For email notifications (optional)

## 📋 Installation Steps

### Step 1: Install Plugins
1. Go to **Manage Jenkins** → **Manage Plugins**
2. Go to **Available** tab
3. Search and install:
   - Git plugin
   - Maven Integration plugin
   - TestNG Results plugin
   - HTML Publisher plugin
4. Restart Jenkins after installation

### Step 2: Configure Global Tools
1. Go to **Manage Jenkins** → **Global Tool Configuration**
2. Configure **Maven**:
   - Name: `Maven-3.9.6`
   - Install automatically: ✅ Check
   - Version: `3.9.6`
3. Configure **JDK**:
   - Name: `JDK-8`
   - JAVA_HOME: `C:\Program Files\Java\jdk1.8.0_xxx` (your JDK path)
4. Save

### Step 3: Create New Jenkins Job
1. Click **New Item**
2. Enter job name: `Selenium-QA-Test-Automation`
3. Select **Freestyle project**
4. Click **OK**

### Step 4: Configure Job Settings

#### Source Code Management
- Select **Git**
- Repository URL: `https://github.com/ramazansener/ramazan_sener_cs.git`
- Credentials: Add your GitHub credentials if private repo
- Branch: `*/main`

#### Build Triggers
- **Poll SCM**: `H/15 * * * *` (check every 15 minutes)
- **GitHub hook trigger for GITScm polling** (if using webhooks)

#### Build Environment
- ✅ **Delete workspace before build starts**
- ✅ **Add timestamps to the Console Output**

#### Build
- **Add build step** → **Invoke top-level Maven targets**
- Maven Version: `Maven-3.9.6`
- Goals: `clean test`
- POM: `pom.xml`

#### Post-build Actions
1. **Publish TestNG Results**
   - TestNG XML report pattern: `**/testng-results.xml`

2. **Publish HTML reports**
   - HTML directory to archive: `target/surefire-reports`
   - Index page[s]: `index.html`
   - Report title: `Selenium Test Reports`

3. **Email Notification** (optional)
   - Recipients: `your-email@domain.com`
   - Send separate emails to individuals who broke the build: ✅

### Step 5: Save and Build
1. Click **Save**
2. Click **Build Now** to test the configuration

## 🚀 Advanced Configuration

### Environment Variables
Add these environment variables in the job:
- `BROWSER=chrome`
- `HEADLESS=false`
- `TEST_URL=https://useinsider.com`

### Parallel Execution
To run tests in parallel, modify pom.xml:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
    <configuration>
        <parallel>methods</parallel>
        <threadCount>3</threadCount>
    </configuration>
</plugin>
```

### Scheduled Builds
For daily builds:
- **Build periodically**: `0 9 * * *` (every day at 9 AM)

## 📊 Monitoring and Reports

### Test Results
- TestNG reports will be available in Jenkins
- HTML reports will be published
- Console output will show detailed test execution

### Email Notifications
Configure email notifications for:
- Build failures
- Test failures
- Build success (optional)

## 🔍 Troubleshooting

### Common Issues:
1. **Maven not found**: Check Maven installation in Global Tools
2. **Git clone fails**: Check repository URL and credentials
3. **Tests fail**: Check browser driver compatibility
4. **Reports not generated**: Check TestNG XML pattern

### Logs to Check:
- Console output for build details
- TestNG reports for test results
- System logs for Jenkins issues

## 📈 Best Practices

1. **Use Pipeline instead of Freestyle** for complex workflows
2. **Implement parallel execution** for faster builds
3. **Add test retry mechanism** for flaky tests
4. **Use Docker containers** for consistent environments
5. **Implement test data management** for different environments 