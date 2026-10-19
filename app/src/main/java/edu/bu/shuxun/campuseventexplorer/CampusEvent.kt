package edu.bu.shuxun.campuseventexplorer

data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val location: String,
    val time: String,
    val description: String
)

object CampusEventData {
    val events: List<CampusEvent> = listOf(
        CampusEvent(
            id = 1L,
            title = "Mobile Development Meetup",
            category = "Technology",
            location = "Commonwealth Ave. 685-725 ROOM 214",
            time = "October 20, 2026, 6:30 PM",
            description = "Meet other students interested in mobile development. " +
                    "Share project ideas and discuss building Android applications."
        ),
        CampusEvent(
            id = 2L,
            title = "Kotlin Study Group",
            category = "Technology",
            location = "Mugar Library",
            time = "October 21, 2026, 5:00 PM",
            description = "Practice Kotlin with classmates through short exercises. " +
                    "Bring your laptop and questions about functions, classes, and state."
        ),
        CampusEvent(
            id = 3L,
            title = "Too good to go pick up",
            category = "Food",
            location = "GSU",
            time = "October 22, 2026, 4:00 PM",
            description = "Get something good in the evening." +
                    "Please get the food in right period."
        ),
        CampusEvent(
            id = 4L,
            title = "Student Art Showcase",
            category = "Arts",
            location = "GSU",
            time = "October 23, 2026, 3:00 PM",
            description = "View paintings, photographs, and illustrations created " +
                    "by students. Meet the artists and hear about their creative process."
        ),
        CampusEvent(
            id = 5L,
            title = "Resume Review Workshop",
            category = "Career",
            location = "Yawkey Center",
            time = "October 24, 2026, 11:00 AM",
            description = "Review your resume with other students and discuss ways " +
                    "to describe your experience. Bring a draft for feedback."
        ),
        CampusEvent(
            id = 6L,
            title = "Internship Networking Night",
            category = "Career",
            location = "Questrom School of Business",
            time = "October 26, 2026, 6:00 PM",
            description = "Meet students from different majors and exchange internship " +
                    "search experiences. Practice introducing yourself in a friendly setting."
        ),
        CampusEvent(
            id = 7L,
            title = "Charles River Running Group",
            category = "Wellness",
            location = "BU Beach",
            time = "October 27, 2026, 7:30 AM",
            description = "Join a relaxed group run along the Charles River. " +
                    "All experience levels are welcome. Wear comfortable shoes and bring water."
        ),
        CampusEvent(
            id = 8L,
            title = "Mindful Study Break",
            category = "Wellness",
            location = "FitRec",
            time = "October 28, 2026, 2:00 PM",
            description = "Take a break from studying with breathing exercises " +
                    "and gentle stretching. No special equipment is needed."
        )
    )
}