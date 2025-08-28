package org.example;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

import java.util.Map;

public class RequestLogger {
    public static void main(String[] args) {
        port(8080);

        get("/*", RequestLogger::handle);
    }

    private static Object handle(Request request, Response response) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head><title>Sample Application - WSO2 IS</title>")
                .append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>")
                .append("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css'>")
                .append("<style>")

                // CSS Variables for theming
                .append(":root {")
                .append("  --primary-color: #ff6b35;")
                .append("  --primary-light: #f7931e;")
                .append("  --primary-gradient: linear-gradient(135deg, #ff6b35 0%, #f7931e 50%, #ff6b35 100%);")
                .append("  --bg-primary: #ffffff;")
                .append("  --bg-secondary: #f8fafc;")
                .append("  --text-primary: #1a202c;")
                .append("  --text-secondary: #4a5568;")
                .append("  --text-muted: #718096;")
                .append("  --border-color: #e2e8f0;")
                .append("  --shadow-sm: 0 1px 3px rgba(0,0,0,0.1);")
                .append("  --shadow-md: 0 4px 6px rgba(0,0,0,0.1);")
                .append("  --shadow-lg: 0 10px 25px rgba(0,0,0,0.1);")
                .append("  --card-bg: rgba(255,255,255,0.95);")
                .append("  --card-border: rgba(255,107,53,0.15);")
                .append("  --code-bg: #f7fafc;")
                .append("}")

                // Dark theme variables
                .append("[data-theme='dark'] {")
                .append("  --bg-primary: #0a0a0a;")
                .append("  --bg-secondary: #1a1a1a;")
                .append("  --text-primary: #ffffff;")
                .append("  --text-secondary: #e2e8f0;")
                .append("  --text-muted: #a0aec0;")
                .append("  --border-color: #4a5568;")
                .append("  --shadow-sm: 0 1px 3px rgba(0,0,0,0.3);")
                .append("  --shadow-md: 0 4px 6px rgba(0,0,0,0.3);")
                .append("  --shadow-lg: 0 10px 25px rgba(0,0,0,0.4);")
                .append("  --card-bg: rgba(30,30,30,0.95);")
                .append("  --card-border: rgba(255,107,53,0.3);")
                .append("  --code-bg: rgba(20,20,20,0.8);")
                .append("}")

                // Google Fonts
                .append("@import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&family=JetBrains+Mono:wght@400;500;600&display=swap');")

                // Base styles
                .append("* { margin: 0; padding: 0; box-sizing: border-box; }")
                .append("html { scroll-behavior: smooth; }")
                .append("body {")
                .append("  font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;")
                .append("  background: var(--bg-primary);")
                .append("  color: var(--text-primary);")
                .append("  min-height: 100vh;")
                .append("  overflow-x: hidden;")
                .append("  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);")
                .append("  line-height: 1.6;")
                .append("}")

                // Layout
                .append(".container { max-width: 1200px; margin: 0 auto; position: relative; z-index: 1; }")

                // Theme toggle
                .append(".theme-toggle {")
                .append("  position: fixed;")
                .append("  top: 2rem;")
                .append("  right: 2rem;")
                .append("  z-index: 100;")
                .append("  background: var(--card-bg);")
                .append("  backdrop-filter: blur(20px);")
                .append("  border: 2px solid var(--card-border);")
                .append("  border-radius: 50px;")
                .append("  padding: 0.8rem 1.2rem;")
                .append("  cursor: pointer;")
                .append("  transition: all 0.3s ease;")
                .append("  box-shadow: var(--shadow-md);")
                .append("  display: flex;")
                .append("  align-items: center;")
                .append("  gap: 0.5rem;")
                .append("}")

                .append(".theme-toggle:hover {")
                .append("  transform: translateY(-2px);")
                .append("  box-shadow: var(--shadow-lg);")
                .append("  border-color: var(--primary-color);")
                .append("}")

                .append(".theme-toggle i {")
                .append("  font-size: 1.2rem;")
                .append("  color: var(--primary-color);")
                .append("  transition: all 0.3s ease;")
                .append("}")

                // Header
                .append("header {")
                .append("  padding: 6rem 2rem 4rem;")
                .append("  text-align: center;")
                .append("  position: relative;")
                .append("}")

                .append(".brand { position: relative; z-index: 2; }")

                .append(".logo {")
                .append("  width: 60px;")
                .append("  height: 60px;")
                .append("  background: var(--primary-gradient);")
                .append("  border-radius: 12px;")
                .append("  margin: 0 auto 2rem;")
                .append("  display: flex;")
                .append("  align-items: center;")
                .append("  justify-content: center;")
                .append("  box-shadow: var(--shadow-md);")
                .append("}")

                .append(".logo i {")
                .append("  font-size: 1.5rem;")
                .append("  color: white;")
                .append("}")

                .append("h1 {")
                .append("  font-size: 3.5rem;")
                .append("  font-weight: 700;")
                .append("  background: var(--primary-gradient);")
                .append("  background-size: 200% 200%;")
                .append("  -webkit-background-clip: text;")
                .append("  -webkit-text-fill-color: transparent;")
                .append("  background-clip: text;")
                .append("  margin-bottom: 1rem;")
                .append("  letter-spacing: -0.02em;")
                .append("}")

                .append(".subtitle {")
                .append("  font-size: 1.4rem;")
                .append("  color: var(--text-muted);")
                .append("  font-weight: 400;")
                .append("  letter-spacing: 0.5px;")
                .append("  margin-bottom: 3rem;")
                .append("}")

                // Main content
                .append(".main-content { padding: 0 2rem 4rem; }")

                .append(".card {")
                .append("  background: var(--card-bg);")
                .append("  backdrop-filter: blur(20px);")
                .append("  border: 2px solid var(--card-border);")
                .append("  border-radius: 24px;")
                .append("  margin-bottom: 2rem;")
                .append("  overflow: hidden;")
                .append("  position: relative;")
                .append("  box-shadow: var(--shadow-lg);")
                .append("  transition: all 0.3s ease;")
                .append("}")

                .append(".card:hover {")
                .append("  transform: translateY(-5px);")
                .append("  box-shadow: 0 20px 40px rgba(255,107,53,0.1);")
                .append("}")

                .append(".card::before {")
                .append("  content: '';")
                .append("  position: absolute;")
                .append("  top: 0;")
                .append("  left: 0;")
                .append("  right: 0;")
                .append("  height: 3px;")
                .append("  background: var(--primary-gradient);")
                .append("}")

                .append(".card-header {")
                .append("  padding: 3rem 3rem 2rem;")
                .append("  border-bottom: 2px solid var(--border-color);")
                .append("}")

                .append("h2 {")
                .append("  font-size: 2.2rem;")
                .append("  font-weight: 700;")
                .append("  color: var(--primary-color);")
                .append("  margin-bottom: 1rem;")
                .append("  display: flex;")
                .append("  align-items: center;")
                .append("  gap: 1rem;")
                .append("}")

                .append("h2 i {")
                .append("  font-size: 1.8rem;")
                .append("}")

                .append(".description {")
                .append("  font-size: 1.2rem;")
                .append("  line-height: 1.7;")
                .append("  color: var(--text-secondary);")
                .append("}")

                .append(".highlight {")
                .append("  background: linear-gradient(135deg, rgba(255,107,53,0.15), rgba(247,147,30,0.15));")
                .append("  padding: 0.4rem 1rem;")
                .append("  border-radius: 12px;")
                .append("  font-weight: 600;")
                .append("  border: 2px solid rgba(255,107,53,0.2);")
                .append("  color: var(--primary-color);")
                .append("}")

                .append("h3 {")
                .append("  font-size: 1.8rem;")
                .append("  font-weight: 600;")
                .append("  color: var(--primary-light);")
                .append("  margin: 2rem 0 1.5rem;")
                .append("  display: flex;")
                .append("  align-items: center;")
                .append("  gap: 0.8rem;")
                .append("}")

                .append("h3 i {")
                .append("  font-size: 1.4rem;")
                .append("}")

                .append(".request-container { padding: 3rem; }")

                // Code styling
                .append("pre {")
                .append("  background: var(--code-bg);")
                .append("  color: var(--text-primary);")
                .append("  padding: 3rem 2.5rem 2.5rem;")
                .append("  border-radius: 20px;")
                .append("  font-size: 1rem;")
                .append("  line-height: 1.7;")
                .append("  overflow-x: auto;")
                .append("  border: 2px solid var(--card-border);")
                .append("  position: relative;")
                .append("  font-family: 'JetBrains Mono', 'SF Mono', Monaco, 'Cascadia Code', monospace;")
                .append("  margin-top: 1.5rem;")
                .append("  box-shadow: var(--shadow-md);")
                .append("}")

                .append("pre::before {")
                .append("  content: 'REQUEST DATA';")
                .append("  position: absolute;")
                .append("  top: -8px;")
                .append("  left: 25px;")
                .append("  background: var(--primary-gradient);")
                .append("  color: white;")
                .append("  font-size: 0.8rem;")
                .append("  font-weight: 700;")
                .append("  padding: 0.4rem 1.2rem;")
                .append("  border-radius: 20px;")
                .append("  font-family: 'Inter', sans-serif;")
                .append("  z-index: 1;")
                .append("  box-shadow: var(--shadow-sm);")
                .append("}")

                // Syntax highlighting
                .append(".method { color: #3b82f6; font-weight: 700; }")
                .append(".uri { color: #10b981; font-weight: 700; }")
                .append(".header-name { color: #a855f7; font-weight: 700; }")
                .append(".cookie-name { color: #f59e0b; font-weight: 700; }")
                .append(".section-divider {")
                .append("  color: var(--primary-color);")
                .append("  font-weight: 700;")
                .append("  margin: 2rem 0 1rem;")
                .append("  font-size: 0.9rem;")
                .append("  letter-spacing: 1px;")
                .append("}")

                // Footer
                .append("footer {")
                .append("  padding: 4rem 2rem;")
                .append("  text-align: center;")
                .append("  position: relative;")
                .append("}")

                .append("footer::before {")
                .append("  content: '';")
                .append("  position: absolute;")
                .append("  top: 0;")
                .append("  left: 50%;")
                .append("  width: 150px;")
                .append("  height: 3px;")
                .append("  background: var(--primary-gradient);")
                .append("  transform: translateX(-50%);")
                .append("  border-radius: 2px;")
                .append("}")

                .append(".tech-badges {")
                .append("  display: flex;")
                .append("  justify-content: center;")
                .append("  flex-wrap: wrap;")
                .append("  gap: 1rem;")
                .append("  margin-bottom: 2rem;")
                .append("}")

                .append(".tech-badge {")
                .append("  background: rgba(255,107,53,0.1);")
                .append("  border: 2px solid rgba(255,107,53,0.3);")
                .append("  color: var(--primary-color);")
                .append("  padding: 0.8rem 1.5rem;")
                .append("  border-radius: 30px;")
                .append("  font-size: 0.9rem;")
                .append("  font-weight: 600;")
                .append("  transition: all 0.3s ease;")
                .append("  display: flex;")
                .append("  align-items: center;")
                .append("  gap: 0.5rem;")
                .append("}")

                .append(".tech-badge:hover {")
                .append("  transform: translateY(-2px);")
                .append("  background: rgba(255,107,53,0.2);")
                .append("  box-shadow: var(--shadow-md);")
                .append("}")

                .append(".footer-text {")
                .append("  color: var(--text-muted);")
                .append("  font-size: 1rem;")
                .append("  font-weight: 500;")
                .append("}")

                // Responsive design
                .append("@media (max-width: 768px) {")
                .append("  h1 { font-size: 2.8rem; }")
                .append("  .container { margin: 0 1rem; }")
                .append("  header { padding: 4rem 1rem 2rem; }")
                .append("  .main-content { padding: 0 1rem 2rem; }")
                .append("  .card-header, .request-container { padding: 2rem 1.5rem; }")
                .append("  .theme-toggle { top: 1rem; right: 1rem; padding: 0.6rem 1rem; }")
                .append("  .tech-badges { flex-direction: column; align-items: center; }")
                .append("}")

                .append("</style>")
                .append("</head><body data-theme='dark'>")

                // Theme toggle button
                .append("<div class='theme-toggle' onclick='toggleTheme()'>")
                .append("<i class='fas fa-sun' id='theme-icon'></i>")
                .append("</div>")

                .append("<div class='noise'></div>")
                .append("<div class='container'>")
                .append("<header>")
                .append("<h1>SAMPLE APPLICATION</h1>")
                .append("</div>")
                .append("</header>")
                .append("<div class='main-content'>")
                .append("<div class='card'>")
                .append("<div class='card-header'>")
                .append("<h2>Application Overview</h2>")
                .append("<div class='description'>")
                .append("This sample application serves as a <span class='highlight'>mockup web application</span> designed for testing identity gateway configurations and proxy setups with WSO2 Identity Server. It captures and displays detailed request information for debugging and analysis purposes.")
                .append("</div>")
                .append("</div>")
                .append("<div class='request-container'>")
                .append("<h3>Request Information</h3>")
                .append("<pre>")
                .append("<span class='section-divider'>CONNECTION INFO</span>\n")
                .append("Protocol: HTTP/1.1\n")
                .append("Method: <span class='method'>").append(request.requestMethod()).append("</span>\n")
                .append("Endpoint: <span class='uri'>").append(request.uri()).append("</span>\n\n");

        if (!request.cookies().isEmpty()) {
            html.append("<span class='section-divider'>SESSION COOKIES</span>\n");
            for (Map.Entry<String, String> entry : request.cookies().entrySet()) {
                html.append("<span class='cookie-name'>").append(entry.getKey()).append("</span> = ").append(entry.getValue()).append("\n");
            }
            html.append("\n");
        }

        html.append("<span class='section-divider'>REQUEST HEADERS</span>\n");
        for (String header : request.headers()) {
            html.append("<span class='header-name'>").append(header).append("</span>: ").append(request.headers(header)).append("\n");
        }

        html.append("</pre>")
                .append("</div>")
                .append("</div>")
                .append("</div>")
                .append("<footer>")
                .append("<div class='tech-badges'>")
                .append("<a href='https://wso2.com' target='_blank' class='tech-badge'><i class='fas fa-server'></i> WSO2</a>")
                .append("<a href='https://wso2.com/identity-server' target='_blank' class='tech-badge'><i class='fas fa-shield-alt'></i> Identity Server</a>")
                .append("<a href='https://wso2.com/blog' target='_blank' class='tech-badge'><i class='fas fa-cog'></i> Blog</a>")
                .append("</div>")
                .append("<div class='footer-text'>")
                .append(" © 2025 WSO2 LLC. All rights reserved")
                .append("</div>")
                .append("</footer>")
                .append("</div>")

                // JavaScript for theme toggle
                .append("<script>")
                .append("function toggleTheme() {")
                .append("  const body = document.body;")
                .append("  const themeIcon = document.getElementById('theme-icon');")
                .append("  const currentTheme = body.getAttribute('data-theme');")
                .append("  ")
                .append("  if (currentTheme === 'dark') {")
                .append("    body.setAttribute('data-theme', 'light');")
                .append("    themeIcon.className = 'fas fa-moon';")
                .append("  } else {")
                .append("    body.setAttribute('data-theme', 'dark');")
                .append("    themeIcon.className = 'fas fa-sun';")
                .append("  }")
                .append("}")
                .append("</script>")

                .append("</body></html>");

        response.type("text/html");
        return html.toString();
    }
}