# AWS: Amazon Web Services
Amazon provides many technical services available in the cloud
They follow a "pay as you go" model, which means you are only charged for the exact uptime of the services that you are leveraging
They also have a series of services that are labelled "free-tier", which will not cost money if used under certain limitations, such as 20 GB storage max, etc.
Some other services are under "free-tier" only for the first 12 months after making an AWS account.

There are MANY different services:
- EC2: Elastic Compute Cloud
  - Our cloud servers
  - Different OSes, such as linux, windows, mac, etc
  - We'll use linux
- EBS: Elastic Block Storage
  - Isolated SSDs, that can be attached to other services
  - Particularly, EC2s
- RDS: Relational Database Service
  - We have used this already
  - Cloud database service
- ELB: Elastic Loud Balancing
  - Control traffic to split between sources/targets evenly
- S3: Simple Storage Service
  - Large Object Storage (up to 5000 TB+)
  - External, isolated storage
  - Different from EBS
  - For example, you could host static webpages (html files)
  - Or perhaps static images
  - etc
- Route 53
  - Domain Name System (DNS) Service
- AMI: Amazon Machine Image
  - OS: Operating System
    - Software that is used to interface between low-level hardware and user actions
  - Images
    - Blueprints for Operating Systems
  - AMI's are different images to create different Operating Systems for your EC2s
- IAM: Identity & Access Management
  - Role-based permissions/security service
  - Can configure different roles
    - Admin
    - Trainers
    - QC
    - Staging
    - etc
- SG: Security Groups
  - Set of rules defining how traffic is filtered
  - What IPs are allowed to access my RDS or EC2?
  - What IPs are my RDS or EC2 allowed to respond TO?

- Auto-Scaling
  - The idea that we want to automatically scale the amount of resources at our disposal
  - Can be quite helpful in industry
  - But on a personal level, could accidentally accrue a lot of cost
  - Can even scale the NUMBER of servers/instances of a service
    - This particular idea differentiates the concepts of vertical and horizontal scaling
    - Vertical scaling: Increases the power of an instance
    - Horizontal scaling: Increases the number of instances

Generally Vertical Scaling was used in industry as a standard because provisioning more servers was a lot of work.

However, with the introduction of cloud-platforms, such as AWS, GCP, Azure, etc, this changed.

The reason, is that these companies became very good at dynamically creating virtual machines. The host systems/machines can share resources (such as memory, storage, etc) across many different virtual machines. This made it much easier to horizontally scale.

Generally speaking, universally, Vertical scaling becomes more expensive the higher scale you go. This is very inefficient money-wise.

As opposed to horizontal scaling: We can just buy another system at the same cost as the first, and that directly doubles our resources.

The biggest impact of being able to efficiently horizontally scale was a simultaneous increase in consumer demand. Services such as facebook and google were becoming more ubiquitous. This means that consumers now expect a similar level of scale from everybody.

Even small companies must now be prepared to scale their products globally. This of course has many challenges. But since that is where the demand is, that is where the profit is.

## Cloud Models

### Software Infrastructure Components
1. Application
2. Data
3. Runtime Environment
4. Middleware
5. Operating System
6. Virtualization
7. Servers
8. Storage
9. Networking

Different Cloud Models offer different portions of the Software Infrastructure Components as a Service
- Software as a Service (SaaS) provides everything from 1 - 9
  - Ex: Google Docs, Microsoft Office 365
  - Ex Providors: Salesforce
  - Ex Consumers: End Users
- Platform as a Service (PaaS) provides everything from 3 - 9
  - Ex: Microsoft Azure, Heroku, AWS Elastic Beanstalk
  - Allows hosting of application/data while bypassing all of the runtime environments and middleware that is handled for you
  - Consumers: Developers
- Infrastructure as a Service (IaaS) provides everything from 5 - 9
  - Ex: AWS EC2
  - Consumers: System Administrators (Sometimes Developers)
