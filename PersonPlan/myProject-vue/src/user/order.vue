<template>
    <div>
        <ve-pie :data="chartData"></ve-pie>
    
        <a-statistic title="总剩余金额" :value="16000" style="margin-right: 50px" />
        <a-statistic title="总支出金额" :precision="2" :value="86000" />
        <a-statistic title="年度总金额" :precision="2" :value="102000" />
        <div>
          <div class="table-operations">
            <a-button @click="setAgeSort">Sort age</a-button>
            <a-button @click="clearFilters">Clear filters</a-button>
            <a-button @click="clearAll">Clear filters and sorters</a-button>
          </div>
          <a-table :columns="columns" :dataSource="data" @change="handleChange" />
        </div> 
    </div>
</template>
<script>
  export default {
    data () {
      return {
        chartData: {
            columns: ['事项', '金额'],
            rows: [
                { '事项': '生活用品', '金额': 150 },
                { '事项': '零食', '金额': 300 },
                { '事项': '饮食', '金额': 1000 },
                { '事项': '衣物', '金额': 800 },
                { '事项': '化妆品', '金额': 3792 },
                { '事项': '房租', '金额': 1500 },
                { '事项': '其他', '金额': 900 },
                { '事项': '剩余', '金额': 1900 },
            ]
        },
        data,
        filteredInfo: null,
        sortedInfo: null,
      }
    },
     computed: {
      columns() {
        let { sortedInfo, filteredInfo } = this;
        sortedInfo = sortedInfo || {};
        filteredInfo = filteredInfo || {};
        const columns = [
          {
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
            filters: [{ text: 'Joe', value: 'Joe' }, { text: 'Jim', value: 'Jim' }],
            filteredValue: filteredInfo.name || null,
            onFilter: (value, record) => record.name.includes(value),
            sorter: (a, b) => a.name.length - b.name.length,
            sortOrder: sortedInfo.columnKey === 'name' && sortedInfo.order,
          },
          {
            title: 'Age',
            dataIndex: 'age',
            key: 'age',
            sorter: (a, b) => a.age - b.age,
            sortOrder: sortedInfo.columnKey === 'age' && sortedInfo.order,
          },
          {
            title: 'Address',
            dataIndex: 'address',
            key: 'address',
            filters: [{ text: 'London', value: 'London' }, { text: 'New York', value: 'New York' }],
            filteredValue: filteredInfo.address || null,
            onFilter: (value, record) => record.address.includes(value),
            sorter: (a, b) => a.address.length - b.address.length,
            sortOrder: sortedInfo.columnKey === 'address' && sortedInfo.order,
          },
        ];
        return columns;
      },
    },
    methods: {
      handleChange(pagination, filters, sorter) {
        console.log('Various parameters', pagination, filters, sorter);
        this.filteredInfo = filters;
        this.sortedInfo = sorter;
      },
      clearFilters() {
        this.filteredInfo = null;
      },
      clearAll() {
        this.filteredInfo = null;
        this.sortedInfo = null;
      },
      setAgeSort() {
        this.sortedInfo = {
          order: 'descend',
          columnKey: 'age',
        };
      },
    },
  }
const data = [
    {
      key: '1',
      name: 'John Brown',
      age: 32,
      address: 'New York No. 1 Lake Park',
    },
    {
      key: '2',
      name: 'Jim Green',
      age: 42,
      address: 'London No. 1 Lake Park',
    },
    {
      key: '3',
      name: 'Joe Black',
      age: 32,
      address: 'Sidney No. 1 Lake Park',
    },
    {
      key: '4',
      name: 'Jim Red',
      age: 32,
      address: 'London No. 2 Lake Park',
    },
  ];
</script>
<style scoped>
   .table-operations {
    margin-bottom: 16px;
  }

  .table-operations > button {
    margin-right: 8px;
  }
</style>