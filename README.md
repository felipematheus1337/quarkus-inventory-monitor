# Quarkus Inventory Monitor 📦

A simple and modern **inventory control system** built with **Quarkus**, designed to explore advanced backend patterns such as event-driven architecture, caching, observability, scheduling, and more.

---

## ✅ Features

- CRUD for **Items** and **Suppliers**
- `@ManyToOne` relationship (Item → Supplier)
- Query for **critical stock items** (low quantity)
- **Scheduled tasks** to monitor and replenish stock
- Event publication to **Kafka**
- **Redis cache** for fast access to common queries
- Structured **logging**
- **Metrics with Prometheus** and dashboards in **Grafana**

---

## 🧱 Tech Stack

- [Quarkus](https://quarkus.io/) (RESTEasy Reactive, Panache, Kafka, Redis, Scheduler, Metrics)
- **PostgreSQL** (relational storage)
- **Redis** (in-memory cache)
- **Apache Kafka** (event streaming)
- **Prometheus** + **Grafana** (monitoring)
- **Docker Compose** (for local orchestration)
---
## 🚀 Getting Started

### Requirements

- Java 17+
- Maven
- Docker + Docker Compose

### Steps

1. Start the infrastructure services:
```bash
docker-compose up -d

Run the Quarkus app:
./mvnw quarkus:dev







