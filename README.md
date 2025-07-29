# Java-Enterprise-HallBookingSystem
#This is my project for Object Oriented Development with Java assigned by my university APU for Outcome Based Learning.

#A simple Java desktop app for managing hall bookings with different user roles—Admin, Manager, Scheduler, and Customer. 
Each user gets their own dashboard to perform tasks like booking, scheduling, or managing users. Built using Java Swing 
and basic OOP, it’s a clean and practical solution for handling hall reservations in schools, offices, or events.

✅ System Requirements
🧑‍💻 Software Requirements
Java Development Kit (JDK) 8 or above – To compile and run the application.

Java Runtime Environment (JRE) – Must be installed if running pre-compiled .class files.

Text File Support – The system uses .txt files for data storage (e.g., users, bookings), so basic file I/O permissions are required.

🖥️ Hardware Requirements
Processor: Minimum Dual-core CPU.

RAM: 4 GB minimum (8 GB recommended for smooth GUI performance).

Storage: At least 200 MB of free space for files and runtime.

OS Compatibility: Works on Windows, macOS, or Linux (any OS that supports Java).

🚀 Getting Started
Install Java
➤ Install JDK 8+

Download or Clone
Copy

git clone https://github.com/yourusername/HallBookingSystem.git
Run the App

Open in any Java IDE (IntelliJ, Eclipse, VS Code)

Run HallBookingSystem.java

Or compile via terminal:

Copy

javac MainLauncher.java
java MainLauncher


👥 User Roles & Dashboards
Role	Features

👨‍💼 Admin	Add/delete users, manage scheduler staff, view bookings/users

📋 Manager	View bookings, issues, sales, assign scheduler, update issue status

🛠 Scheduler	Add/edit/delete halls, set availability/maintenance, update booking

🙋‍♂️ Customer	Book/cancel halls, view availability, raise issues, update profile

🖱 How to Use
Login 🧑‍💻
Choose your role, enter username & password.
First Use Admin Login : admin admin123

Navigate Dashboard 📊

Each role sees different options (e.g., Admin can manage users, Customer can book halls).

Perform Actions ✅

📅 Book or cancel halls

🧾 View bookings or issues

🔧 Set hall maintenance

✉️ Raise or resolve issues

💾 Data Storage
User and booking data are stored in .txt files (e.g., users.txt, bookings.txt).

No database required.
