Pet Care Management App (Pet Planner)

# Week 1-3: Database Design & Project Setup

User Stories Addressed: Foundation for all features

Tasks:
- [x] Design database schema (Users, Pets, Schedules, Medications, SharedSchedules tables)
- [x] Define entity relationships and constraints
- [x] Create ER diagram
- [x] Set up Java project structure
- [x] Configure Maven/Gradle dependencies
- [x] Set up Git repository
- [x] Create initial project documentation
- [x] Initialize Spring Boot application (if applicable)

---

# Week 4-6: Hibernate Setup & Pet Management

User Stories Addressed:
- As Jessica Jaxon, I want to easily delete individual pet profiles and their associated data
- Foundation for Jake, Julia, and Perry's pet management needs

Tasks Week 4:
- [x] Set up database connection properties
- [x] Configure Hibernate settings
- [x] Create base entity classes
- [x] Set up DAO
- [x] Implement CRUD operations
- [x] Write tests for CRUD operations

Tasks Week 5-6:
- [ ] Design Pets table structure (id, name, type, age, owner_id, medical_notes, etc.) 
- [ ] Create Pet entity class with annotations
- [ ] Implement Pet DAO
- [ ] Build Pet CRUD operations:
  * Create new pet profile
  * Read/view pet details
  * Update pet information
  * Delete pet profile (with confirmation)
- [ ] Write tests for Pet CRUD

Tasks Week 5-6 (Updated)
- [x] All original goals - but replaced with Family table

---

# Week 7-9: Schedule Creation & Family Sharing

User Stories Addressed:
- As Jake Billiams, I want to set up automated feeding schedules with reminders
- As Julia Boberts, I want to create scheduled medication reminders
- As Perry Botter, I want to share a detailed care schedule with notes to my friend
- As Perry Botter, I want to collaborate on and share pet care schedules so that anyone caring for my animals has access to correct, up-to-date information

Tasks Week 7:
- [ ] Design Schedule table (id, pet_id, task_type, frequency, time, notes, etc.)
- [ ] Create Schedule entity class
- [ ] Implement Schedule DAO
- [ ] Build schedule CRUD operations

Tasks Week 8:
- [ ] Create schedule builder interface
- [ ] Implement recurring schedule logic (daily, weekly, custom)
- [ ] Add medication tracking fields to schedules
- [ ] Build schedule filtering (by pet, by date, by type)
- [ ] Write tests for schedule operations

Tasks Week 9 - Family Feature: (Still thinking this one through)
- [ ] Design Family table (id, family_name, created_by, created_at)
- [ ] Design FamilyMembers table (id, family_id, user_id, role, permissions, invited_at, joined_at)
    * Roles: "Head" (creator), "Editor", "Viewer"
    * Permissions: can_edit_schedule, can_add_pets, can_invite_members
- [ ] Update Pets table to include family_id (pets belong to families)
- [ ] Update Schedules to be associated with families through pets
- [ ] Create Family entity and relationships
- [ ] Implement Family CRUD operations:
    * Create new family
    * View family details
    * Update family information
    * Delete family (with confirmation and cascade rules)
- [ ] Build Family member management:
    * Invite members by email
    * Accept/decline invitations
    * Assign roles and permissions
    * Remove members (Head only)
    * Transfer Head role
- [ ] Implement access control logic:
    * Head can: manage all family settings, invite/remove members, edit all schedules, manage all pets
    * Editor can: edit schedules, add/edit pets (if permitted), view all family data
    * Viewer can: view schedules and pet information only
- [ ] Build Family dashboard showing:
    * All family pets
    * All family members
    * Consolidated schedule view
    * Member management interface (for Head)
- [ ] Add pet assignment to family during creation
- [ ] Implement permission checks throughout application
- [ ] Test family sharing and permission scenarios

- [ ] Week 9 To Be Updated due to week 5-6 changes
---

# Week 10-12: User Profiles & Styling

User Stories Addressed:
- As Jake Billiams, I want flexible data management
- As Perry Botter, I want accurate information sharing
- All users need profile management

Tasks Week 10:
- [ ] Design Users table (id, name, email, password_hash, created_at, etc.)
- [ ] Create User entity class
- [ ] Implement user authentication/registration
- [ ] Build user profile CRUD operations
- [ ] Create user dashboard view

Tasks Week 11:
- [ ] Build pet profile display pages
- [ ] Create pet profile edit forms
- [ ] Add pet photo upload capability (optional)
- [ ] Implement profile validation
- [ ] Link pets to user accounts

Tasks Week 12:
- [ ] Integrate Bootstrap CSS framework
- [ ] Design responsive navigation menu
- [ ] Style user dashboard
- [ ] Style pet profile pages
- [ ] Style schedule creation forms
- [ ] Style sharing interface
- [ ] Ensure mobile responsiveness
- [ ] Add consistent color scheme and branding

---

# Week 13-15: Reminder System (If Time Permits)

User Stories Addressed:
- As Jake Billiams, I want reminders so I can ensure consistent feeding times
- As Julia Boberts, I want reliable reminders so I never miss a dose

Tasks Week 13:
- [ ] Research notification APIs:
  * Email APIs
  * SMS APIs
- [ ] Evaluate implementation complexity / no cost options
- [ ] Choose notification method(s)

Tasks Week 14:
- [ ] Create Reminders table (id, schedule_id, user_id, send_time, status, etc.)
- [ ] Implement reminder scheduling logic
- [ ] Configure email/SMS templates

Tasks Week 15:
- [ ] Implement email/SMS sending functionality
- [ ] Add reminder preferences to user profile
- [ ] Build reminder management interface:
  * Enable/disable reminders
  * Set reminder frequency
  * Manage notification preferences
- [ ] Test reminder delivery
- [ ] Handle notification failures and retries

---

# Week 16: Final Testing & Debugging
User Stories Addressed: All - ensuring quality and reliability