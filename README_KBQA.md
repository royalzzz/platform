# KBQA 基于知识库的智能问答系统

## Elastic Search Index 设计

### 1.chemical Mapping
```json
{
    "properties": {
        "chemical_id": {
            "type": "long"
        },
        "name": {
            "type": "text",
            "index": true,
            "analyzer":"standard"
        }
    }
}
```

### 2. import sds chemicals