# Verification

Checked on October 19, 2026.

## Emulator checks performed by the student

| Check | Result | Evidence |
| --- | --- | --- |
| Search by category and open an event | Passed | [Filtered list](screenshots/event-search.png) |
| Show all required event details and return with app-bar Up | Passed | [Detail screen](screenshots/event-detail.png); student confirmation |
| Open the Android Sharesheet with title, time, and location | Passed | [Sharesheet](screenshots/event-share.png) |
| Search, open details, rotate, remain on details, press system Back, retain search, open another event, and press system Back again | Passed | Student reported completing the required sequence |
| Navigate using an unknown ID, show an unavailable message, and return without crashing | Passed | [Temporary invalid-ID test](screenshots/invalid-event-test.png); student confirmation |

The invalid-ID screenshot shows a temporary test using `-1L`. The production navigation was restored to `EventDetail(eventId = eventId)` before the second commit.

## Build and static checks run by Codex

Command: `./gradlew :app:assembleDebug :app:lintDebug`

Both tasks passed after cleanup. Lint reports seven available-version suggestions for build tools and dependencies; these versions were retained after successful testing. Generated reports and build outputs are excluded from Git.
