Author: Kamilzhanova Elmira

Implemented student CRUD:
POST /api/students — create a student.
GET /api/students — get all students.
GET /api/students/{id} — get one student.
PUT /api/students/{id} — update a student.
DELETE /api/students/{id} — delete a student.

Missing students return HTTP 404.
GET /api/info displays the author's name.

Local development uses an in-memory H2 database.
PostgreSQL will be configured through Docker Compose.

Documentation: initial
Documentation status: final version by Kamilzhanova Elmira

CI: Jenkins checks GitHub for changes every five minutes.

CI: Jenkins checks GitHub for changes every f5 minutes.

Automatic CI check after main build.
