<template>
    <div>
        <form>
           <div>
            <label for="start-address">What is your starting point?</label>
            <input type="text" name="start-address">
           </div>
            <div>
                <label for="distance">How many miles would you like to travel?</label>
                <input type="number" name="distance" max="20" min="0" step="0.1">
            </div>
            <div>
                <label for="date">Please select a date </label>
                <input type="date" name="date">
            </div>
            <div>
                <label for="start-time">What is your start time?</label>
                <input type="time" name="start-time">
            </div>
            <div>
                <label for="end-time">What is your end time?</label>
                <input type="time" name="end-time">
            </div>
            
        </form>
        <label>Land Marks Found</label>
    </div>
</template>


<script>
    export default{

    }
</script>