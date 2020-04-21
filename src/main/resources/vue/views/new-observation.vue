<template id="new-observation">
    <div>
        <h1>Create new observation</h1>
        <form class="create" @submit="checkForm" :action=`/api/observations/new` method="post">
            <p>
                <label for="name">Name</label>
                <input type="text" name="name" id="name" v-model="name">
            </p>

            <p>
                <label for="quantity">Quantity</label>
                <input type="text" name="quantity" id="quantity" v-model="quantity">
            </p>

            <p>
                <label for="animal">Animal</label>
                <select name="animal" id="animal" v-model="animal">
                    <option v-bind:value="animal.name" v-for="animal in animals">{{animal.name}}</option>
                </select>
            </p>

            <p>
                <label for="location">Location</label>
                <select name="location" id="location" v-model="location">
                    <option v-bind:value="location.name" v-for="location in locations">{{location.planet.name}}</option>
                </select>
            </p>

            <p>
                <label for="date">Date</label>
                <input type="date" name="date" id="date" v-model="date">
            </p>

            <p>
                <label for="comment">Comment</label>
                <input type="feald" name="comment" id="comment" v-model="comment">
            </p>
        </form>
    </div>
</template>
<script>
    Vue.component("new-observation", {
        template: "#new-observation",
        data: () => ({
            name: null,
            quantity: null,
            image: null,
            animal: null,
            date: null,
            location: null,
            comment: null,
            animals: [],
            locations: [],
        }),
        created() {
            fetch(`/api/animals`)
                .then(res => res.json())
                .then(res => this.animals = res)
                .catch(() => alert("error while fetching animals"));
            fetch(`/api/locations`)
                .then(res => res.json())
                .then(res => this.locations = res)
                .catch(() => alert("error while fetching locations"));
        },
        methods:{
            checkForm:function (e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                e.prevemtDefault();
            }
        }
    })
</script>
<style>
    p {
        height: auto;
    }

    select {
        margin: 0;
    }
</style>