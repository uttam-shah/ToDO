# To-Do App with MVVM Architecture

## Project Overview

I developed this **To-Do App** for Android using **Kotlin** and **MVVM architecture** to offer a scalable and maintainable solution for task management. The app features a **clean and intuitive user interface** that helps users manage their tasks efficiently and effectively.

## Key Features

- **Task Management**: Users can create, edit, and list tasks with **due dates**, **times**, **priority levels**, and **categories**. This allows for organized task management based on importance and context.

- **Priority and Categorization**: Assign **priority levels** (e.g., high, medium, low) and organize tasks into **custom categories** for a personalized and efficient organization system.

- **Advanced UI/UX Design**: The app features a **user-friendly interface** based on **material design principles**, making task management seamless and visually appealing.

- **MySQL Integration**: Sync tasks across devices via a **MySQL database**. Users can log in from any device to access their tasks and categories from the cloud.

- **Authentication**: Secure user login and registration are handled through **Firebase Authentication**, ensuring data protection and accessibility across devices.

- **Offline Mode**: Manage tasks even without an internet connection. Data is automatically synced with the database once the user is online.

- **Notifications and Reminders**: Receive timely **notifications and reminders** about upcoming tasks based on due dates and times to stay organized.

- **Task Completion**: Mark tasks as completed to track progress and accomplishment.

- **Analytics and Insights (Upcoming)**: Planned features to provide **analytics** and **insights** into task management and productivity trends.

## How It Helps

- **Enhanced Productivity**: Streamline task management by allowing users to set priorities and deadlines, helping them focus on what matters most.
  
- **Efficient Organization**: Custom categories and priority levels enable users to organize tasks effectively, reducing clutter and improving workflow.

- **Seamless Synchronization**: Cross-device syncing ensures users can manage tasks from any device, providing flexibility and continuity.

- **Offline Functionality**: Manage tasks without internet access, ensuring productivity is not interrupted by connectivity issues.

## Technologies Used

- **MVVM Architecture**: Separates concerns into **Model**, **View**, and **ViewModel** for cleaner and more maintainable code.

- **Room Database**: Used for **local data storage**, enabling offline functionality and efficient task management.

- **Firebase**: Provides **Authentication** for secure login and **Firebase Storage** for managing task-related files.

- **Retrofit**: Handles **API calls** and **communication** with the MySQL backend, ensuring smooth data synchronization.

- **LiveData and ViewModel**: Manages and observes **UI-related data**, making the interface responsive and lifecycle-aware.

- **Custom Libraries**:
  - **CircleImageView**: For circular profile pictures.
  - **PinView**: For secure input fields.
  - **Glide**: For image loading and caching.
  - **Material DateTime Picker**: For enhanced date and time selection.
  - **ColorPickerView**: For customizing categories.

## Requirements

- **Android Studio**: For development and building the app.
- **Kotlin**: Programming language used.
- **Firebase**: For user authentication and file storage.
- **Room Database**: For local data storage.
- **MySQL**: For cloud synchronization.
- **Retrofit**: For API interactions and data fetching.

## GitHub Repository

Explore the source code and contribute to the project here: [To-Do App Repository](https://github.com/uttam-shah/ToDo.git)
