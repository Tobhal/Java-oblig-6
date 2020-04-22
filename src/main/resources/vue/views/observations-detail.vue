<template id="observations-detail">
    <div>
        <h1 id="observation">{{observation.name}} <span id="observation-id">(id: {{observation.id}})</span></h1>

        <p id="date">{{observation.date.dayOfMonth}}.{{observation.date.month}}.{{observation.date.year}}</p>

        <figure id="observation-image">
            <img :src="`${observation.image}`">
        </figure>

        <p id="animal">Observed animal: <br>
            <a :href="`/observations/${observation.name}/animal`">{{observation.animal.name}}</a> <br>
            quantity: {{observation.quantity}}
        </p>

        <p id="location">Location: <br>
            Planet: <a :href="`/observations/${observation.name}/planet`">{{observation.location.planet.name}}</a> <br>
            Coordinates: {{observation.location.longitude}}/{{observation.location.latitude}} <br>
            Biomes: <span v-for="biome in observation.location.biomes">{{biome}}, </span>
        </p>

        <p id="comment">Comment: <br> {{observation.comment}}</p>
        <a :href="`/observations/${observation.name}/update`">Update</a>
        <a :href="`/api/observations/${observation.name}/delete`">Delete</a>
    </div>
</template>
<script>
    Vue.component("observations-detail", {
        template: "#observations-detail",
        data: () => ({
            observation: null,
        }),
        created() {
            const observationName = this.$javalin.pathParams["observation-name"];
            fetch(`/api/observations/${observationName}`)
                .then(res => res.json())
                .then(res => this.observation = res)
                .catch(() => alert("error while fetching observation"));
        }
    });
</script>
<style>
    #observation {
        margin-bottom: 0;
        padding-bottom: 0;
    }

    #observation-id {
        font-size: medium;
        color: gray;
    }

    #observation-image {
        float: right;
    }

    #date {
        margin-top: 0;
        color: gray;
        font-size: medium;
    }

    #animal {
        margin: 10px 0 30px 0;
        font-size: large;
    }
</style>