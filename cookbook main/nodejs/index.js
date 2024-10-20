const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const server = express();
server.use(express.json());
server.use(cors());

const mongoURI = 'mongodb+srv://mayurvicky01234:71jOFlZokZB097DA@cookbook.6ij88.mongodb.net/recipe_app_db?retryWrites=true&w=majority&appName=cookbook';
mongoose.connect(mongoURI, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

mongoose.connection.on('connected', () => {
  console.log('Connected to MongoDB');
});

mongoose.connection.on('error', (err) => {
  console.log('Error connecting to MongoDB:', err);
});

const RecipeSchema = new mongoose.Schema({
  title: { type: String, required: true },
  photo_url: { type: String, required: true },
  ingredients: { type: [String], required: true },
  steps: { type: [String], required: true },
  tags: { type: [String], default: [] },
});

const PopularRecipeSchema = new mongoose.Schema({
  title: { type: String, required: true },
  title2: { type: String, required: true },
  description: { type: String, required: true },
  photo_url: { type: String, required: true },
  type_url: { type: String, required: true },
});

const Recipe = mongoose.model('Recipe', RecipeSchema);
const PopularRecipe = mongoose.model('PopularRecipe', PopularRecipeSchema);

server.get('/recipes', async (req, res) => {
  console.log('Received request to /recipes');
  console.log('Received request body:', req.body);
  try {
    const recipes = await Recipe.find();
    res.status(200).json(recipes);
  } catch (error) {
    console.error('Error fetching recipes:', error);
    res.status(500).json({ error: 'Failed to fetch recipes' });
  }
});

server.get('/popularrecipes', async (req, res) => {
  
  console.log('Received request to /popular'); // Debugging line
  try {
    const popular = await PopularRecipe.find();
    console.log('Fetched popular recipes:', popular); // Debugging line
    res.status(200).json(popular);
  } catch (error) {
    console.error('Error fetching popular recipes:', error);
    res.status(500).json({ error: 'Failed to fetch popular recipes' });
  }
});


server.post('/recipes', async (req, res) => {
  const { title, photo_url, ingredients, steps, tags } = req.body;

  if (!title || !photo_url || !ingredients || !steps) {
    return res.status(400).json({ error: 'Title, photo_url, ingredients, and steps are required.' });
  }

  try {
    const newRecipe = new Recipe({
      title,
      photo_url,
      ingredients,
      steps,
      tags,
    });

    await newRecipe.save();
    res.status(201).json({ message: 'Recipe created successfully!', recipe: newRecipe });
  } catch (error) {
    console.error('Error saving recipe:', error);
    res.status(500).json({ error: 'Failed to create recipe' });
  }
});

server.get('/test', async (req, res) => {
  try {
    await mongoose.connection.db.admin().ping();
    res.json({ message: 'Connected to MongoDB Atlas' });
  } catch (error) {
    res.status(500).json({ error: 'Failed to connect to MongoDB Atlas' });
  }
});

server.listen(8080, () => {
  console.log('Server started on port 8080');
});
