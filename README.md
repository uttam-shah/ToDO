Project Description: To-Do App with MVVM Architecture

I developed a to-do application for Android using Kotlin and MVVM architecture to ensure scalability and maintainability. The app offers a clean and intuitive user interface, allowing users to manage their tasks efficiently.

Key Features:
Task Management: Users can create, edit, and list their tasks. Each task can have a due date, time, priority, and category, ensuring that users can organize their tasks effectively based on importance and context.

Priority and Categorization: Users can assign priority levels to tasks (e.g., high, medium, low) and categorize tasks into different sections or custom categories for a personalized organization system.

Advanced UI/UX Design: The app features an advanced, user-friendly interface with a focus on material design principles, making task management seamless and visually appealing.

MySQL Integration: The app is connected to a MySQL database, which allows users to sync their tasks across devices. Users can log in on another device and seamlessly access their tasks and categories from the cloud.

Authentication: User authentication is handled through Firebase Authentication, ensuring secure login and registration across devices.

Offline Mode: Users can also manage their tasks without an internet connection. If they create an account, their data is automatically synced with the database once online.

Notifications and Reminders: The app includes a notification and reminder feature that sends timely reminders about upcoming tasks based on the due date and time, ensuring users stay organized.

Task Completion: Users can mark tasks as completed when done, giving a sense of progress and accomplishment.

Analytics and Insights (Upcoming): I plan to implement a feature that provides analytics on task management, offering users insights into their productivity and task completion trends.

Technologies Used:
MVVM Architecture: This architectural pattern separates concerns into the Model, View, and ViewModel, promoting cleaner and more maintainable code.

Room Database: For local data storage, the app uses the Room database to store tasks and categories, ensuring offline capability.

Firebase: Integrated Firebase services, including Authentication for secure login and Firebase Storage for managing files and media associated with tasks.

Retrofit: API calls and communication with the MySQL backend are handled via Retrofit, ensuring smooth data synchronization between the app and the server.

LiveData and ViewModel: Utilized LiveData and ViewModel for managing and observing UI-related data, making the UI responsive and lifecycle-aware.

Custom Libraries: The app incorporates various third-party libraries such as:

CircleImageView for creating circular profile pictures.
PinView for secure input fields.
Glide for image loading and caching.
Material DateTime Picker for enhanced date and time selection.
ColorPickerView for category customization.
