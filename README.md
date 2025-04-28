# HomeScript Language

## Context:
**HomeScript** is a domain-specific programming language (DSL) designed to simplify home automation tasks. With an intuitive, easy-to-learn syntax, it enables users to quickly and clearly define rules for the intelligent control of household devices.

By leveraging everyday events such as "motion detection", "door opening", or time-based conditions like specific hours, users can effortlessly create automations to make their homes safer, more comfortable, and more efficient.

**Main features:**

- Simple, user-friendly syntax;
- Clear definition of rules based on events and actions;
- Easy configuration of smart home devices;
- Ideal for users without prior programming experience.

## Code Examples:
**Motion Detection at night:**
```homs
when motion_detected in "garage" after 23:00 {
    turn_on "garage_light"
    notify "smartphone", "Motion detected in the garage at night!"
}
```

**Morning Routine Automation:**
```homs
when motion_detected in "bedroom" after 06:00 {
    turn_on "coffee_maker"
    play_music "bedroom_speaker", "Morning Playlist"
    open "window_blinds"
}
```

**Door Security:**
```homs
when door_opened in "front_door" before 07:00 {
    activate_alarm "security_system"
    notify "smartphone", "Front door opened before 7 AM!"
}
```

**Temperature Control:**
```homs
when temperature_high in "living_room" after 14:00 {
    turn_on "air_conditioner"
    set_temperature "air_conditioner", "22"
    notify "smartphone", "Air conditioning activated, temperature set to 22°C."
}
```

**Direct Device Control (without conditions):**
```homs
turn_off "living_room_light"
lock "front_door"
set_temperature "bedroom1_thermostat", "20"
```