# Real-Time Chat API - H Technologies

Bienvenue dans la documentation de l'API de chat en temps réel développée par **H Technologies**. Cette API permet aux utilisateurs d'envoyer et de recevoir des messages instantanément grâce à WebSocket et REST.

## 🚀 Fonctionnalités
- 📡 **Messagerie en temps réel** via WebSocket
- 🔐 **Authentification JWT** pour sécuriser l'accès
- 👥 **Gestion des utilisateurs** (inscription, connexion, profils)
- 🏷️ **Gestion des salons de discussion** (publics et privés)
- 📦 **Historique des messages** stocké dans une base de données
- 🔔 **Notifications en temps réel** pour les nouveaux messages

## 🛠️ Technologies utilisées
- **Backend** : Node.js avec Express.js
- **Base de données** : MongoDB avec Mongoose
- **Authentification** : JSON Web Token (JWT)
- **Temps réel** : Socket.io
- **Stockage des fichiers** : AWS S3 (optionnel)

## 📌 Prérequis
- Node.js >= 16.x
- MongoDB installé ou accès à une base de données MongoDB Cloud

## 🚀 Installation
```bash
# Cloner le dépôt
git clone https://github.com/H-Technologies/real-time-chat-api.git
cd real-time-chat-api

# Installer les dépendances
npm install

# Configurer les variables d'environnement
cp .env.example .env
# Modifier le fichier .env avec vos paramètres

# Démarrer le serveur
dev: npm run dev  # Mode développement
prod: npm start   # Mode production
```

## 📡 Endpoints principaux

### Authentification
- `POST /api/auth/register` - Inscription d'un utilisateur
- `POST /api/auth/login` - Connexion et récupération du token JWT

### Utilisateurs
- `GET /api/users` - Liste des utilisateurs
- `GET /api/users/:id` - Détails d'un utilisateur

### Messages
- `POST /api/messages` - Envoyer un message
- `GET /api/messages/:chatId` - Récupérer l'historique des messages d'un chat

### Salons de discussion
- `POST /api/chats` - Créer un salon de discussion
- `GET /api/chats` - Lister les salons disponibles

## 🔌 WebSocket Events
- `connect` - Connexion d'un utilisateur
- `disconnect` - Déconnexion d'un utilisateur
- `sendMessage` - Envoi d'un message
- `receiveMessage` - Réception d'un message
- `joinRoom` - Rejoindre un salon

## 📜 Licence
Ce projet est sous licence MIT.

---
Développé avec ❤️ par **H Technologies**
