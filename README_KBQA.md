# KBQA 基于知识库的智能问答系统

## Elastic Search Index 设计

### 1.chemical Mapping
```json
{
    "properties": {
        "chemical_id": {
            "type": "long"
        },
        "smart_name": {
            "type": "text",
            "analyzer":"ik_smart",
            "index_options": "docs"
        },
        "standard_name": {
            "type": "text",
            "analyzer":"standard",
            "index_options": "docs"
        }
    }
}
```

### 2. import sds chemicals